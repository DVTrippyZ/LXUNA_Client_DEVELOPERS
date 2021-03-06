#version 150

uniform sampler2D DiffuseSampler;
uniform float Saturation;
uniform float Enabled;

in vec2 texCoord;

const vec3 luminance = vec3(0.2126, 0.7152, 0.0722);

out vec4 FragColor;

void main() {
    vec4 texel = texture(DiffuseSampler, texCoord);
    if (Enabled == 1.0) {
        vec3 gray = vec3(dot(texel.rgb, luminance));
        FragColor = vec4(mix(gray, texel.rgb, Saturation), texel.a);
    } else {
        FragColor = texel;
    }
}
