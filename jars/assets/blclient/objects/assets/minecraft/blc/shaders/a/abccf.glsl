#version 110

varying vec4 outColor;
varying vec2 outTexCoords;
varying vec2 outLightCoords;
varying float outVertexDistance;

uniform float fogDensity;
uniform int fogType;
uniform float fogStart;
uniform float fogEnd;
uniform vec4 fogColor;

uniform sampler2D textureIn;
uniform sampler2D lightIn;
uniform float bedColor;
uniform vec2 override;
uniform vec4 uv[5];
uniform bool skip;

const vec3 luminance = vec3(0.2126, 0.7152, 0.0722);

vec4 linear_fog(vec4 vertexColor, float vertexDistance)
{
    if (vertexDistance <= fogStart)
    {
        return vertexColor;
    }

    float fogValue = vertexDistance < fogEnd ? smoothstep(fogStart, fogEnd, vertexDistance) : 1.0;
    return vec4(mix(vertexColor.rgb, fogColor.rgb, fogValue * fogColor.a), vertexColor.a);
}

void fog(vec4 color)
{
    if (fogType == 0)
    {
        gl_FragColor = color;
    }
    else if (fogType == 1)
    {
        gl_FragColor = linear_fog(color, outVertexDistance);
    }
    else if (fogType == 2)
    {
        float fogFactor = exp(-fogDensity * outVertexDistance);

        fogFactor = clamp(fogFactor, 0.0, 1.0);

        gl_FragColor = vec4(mix(fogColor.rgb, color.rgb, fogFactor), color.a);
    }
    else if (fogType == 3)
    {
        float fogFactor = exp(-pow((fogDensity * outVertexDistance), 2.0));

        fogFactor = clamp(fogFactor, 0.0, 1.0);
        gl_FragColor = vec4(mix(color.rgb, fogColor.rgb, fogFactor), color.a);
    }
}

vec3 rgb2hsv(vec3 c)
{
    vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);
    vec4 p = c.g < c.b ? vec4(c.bg, K.wz) : vec4(c.gb, K.xy);
    vec4 q = c.r < p.x ? vec4(p.xyw, c.r) : vec4(c.r, p.yzx);
    float d = q.x - min(q.w, q.y);
    float e = 1.0e-10;
    return vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);
}

vec3 hsv2rgb(vec3 c)
{
    vec4 K = vec4(1.0, 2.0 / 3.0, 1.0 / 3.0, 3.0);
    vec3 p = abs(fract(c.xxx + K.xyz) * 6.0 - K.www);
    return c.z * mix(K.xxx, clamp(p - K.xxx, 0.0, 1.0), c.y);
}

void main() {
    vec4 color = texture2D(textureIn, outTexCoords) * outColor;
    vec4 color0 = color;
    #ifdef OPTIFINE
    color0 = color * texture2D(lightIn, outLightCoords);
    fog(color0);
    #else
    gl_FragColor = color0;
    #endif


    if (!skip) {
        if (override.x > 0.) {
            vec3 grayScale = override.y > 0. ? vec3(dot(color0.rgb, luminance)) : vec3(dot(color.rgb, luminance));
            color0.rgb = override.y > 0. ? grayScale : vec3(0.8 - grayScale.x, 0.8 - grayScale.y, 0.8 - grayScale.z);
        } else {
            vec3 current = rgb2hsv(color0.rgb);
            current.r = 0.;
            current.r += bedColor;
            color0.rgb = hsv2rgb(current);
        }
        for (int i = 0; i < 5; i++) {
            if (outTexCoords.x > uv[i].x && outTexCoords.x < uv[i].y &&
            outTexCoords.y > uv[i].z && outTexCoords.y < uv[i].w) {
                #ifdef OPTIFINE
                fog(color0);
                #else
                gl_FragColor = color0;
                #endif
            }
        }
    }
}