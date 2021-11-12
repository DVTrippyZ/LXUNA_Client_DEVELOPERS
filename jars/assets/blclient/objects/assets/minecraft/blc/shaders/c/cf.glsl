#version 150
out vec4 fragColor;

in vec2 outTexCoord;
in vec4 outLightColor;
in vec4 outVertexColor;

uniform sampler2D defaultSampler;

void main() {
    vec4 color = texture(defaultSampler, outTexCoord);
    if (color.a < 0.1) {
        discard;
    }
    color *= outVertexColor;
    color *= outLightColor;
    fragColor = color;
}