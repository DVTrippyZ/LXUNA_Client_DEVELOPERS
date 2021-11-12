#version 150

in vec3 position;
in vec4 vertexColor;
in vec2 texCoord;
in vec2 lightTexCoord;
in vec3 normals;

out vec2 outTexCoord;
out vec4 outLightColor;
out vec4 outVertexColor;

uniform mat4 modelViewMatrix;
uniform mat4 projectionMatrix;
uniform vec3 playerPosition;

uniform vec3 light0;
uniform vec3 light1;

uniform sampler2D lightmapSampler;

#define lightPower   (0.6)
#define ambientLight (0.4)

vec4 minecraft_mix_light(vec3 lightDir0, vec3 lightDir1, vec3 normal, vec4 color) {
    lightDir0 = normalize(lightDir0);
    lightDir1 = normalize(lightDir1);
    float light0 = max(0.0, dot(lightDir0, normal));
    float light1 = max(0.0, dot(lightDir1, normal));
    float lightAccum = min(1.0, (light0 + light1) * lightPower + ambientLight);
    return vec4(color.rgb * lightAccum, color.a);
}

void main() {
    gl_Position = projectionMatrix * modelViewMatrix * vec4(position.x - playerPosition.x,
    position.y - playerPosition.y, position.z - playerPosition.z, 1.0);
    outTexCoord = texCoord;
    outLightColor = texelFetch(lightmapSampler, ivec2(lightTexCoord.xy), 0);

    outVertexColor = minecraft_mix_light(light0, light1, normalize(normals), vertexColor);
}

