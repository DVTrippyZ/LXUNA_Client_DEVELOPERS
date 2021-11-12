#version 150

out vec4 FragColor;

uniform vec2 resolution;
uniform sampler2D texture0;
uniform sampler2D texture1;
uniform float combine;

void main() {
    vec2 uv = vec2(gl_FragCoord.xy / resolution);

    vec4 texture0Color = texture(texture0, uv);
    vec4 texture1Color = texture(texture1, uv);

    FragColor = texture0Color + texture1Color * combine;
}