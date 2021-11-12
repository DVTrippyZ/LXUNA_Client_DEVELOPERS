#version 120

varying vec2 outTexCoord;
varying vec4 outLightColor;
varying vec4 outVertexColor;
varying float vertexDistance;

uniform sampler2D defaultSampler;
uniform float FogStart;
uniform float FogEnd;
uniform vec4 FogColor;

vec4 linear_fog(vec4 inColor, float vertexDistance, float fogStart, float fogEnd, vec4 fogColor) {
    if (vertexDistance <= fogStart)
    {
        return inColor;
    }

    float fogValue = vertexDistance < fogEnd ? smoothstep(fogStart, fogEnd, vertexDistance) : 1.0;
    return vec4(mix(inColor.rgb, fogColor.rgb, fogValue * fogColor.a), inColor.a);
}

void main() {
    vec4 color = texture2D(defaultSampler, outTexCoord);
    if (color.a < 0.1)
    {
        discard;
    }
    color *= outVertexColor;
    color *= outLightColor;
    gl_FragColor = linear_fog(color, vertexDistance, FogStart, FogEnd, FogColor);
}
