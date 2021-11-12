#version 120

#define MINECRAFT_LIGHT_POWER   (0.2)
#define MINECRAFT_AMBIENT_LIGHT (0.8)

attribute vec3 normals;

varying vec2 outTexCoord;
varying vec4 outLightColor;
varying vec4 outVertexColor;
varying float vertexDistance;

uniform vec3 light0;
uniform vec3 light1;
uniform ivec2 lightTexCoord;

uniform sampler2D lightmapSampler;

vec4 minecraft_mix_light(vec3 lightDir0, vec3 lightDir1, vec3 normal) {
    lightDir0 = normalize(lightDir0);
    lightDir1 = normalize(lightDir1);
    float light0 = max(0.0, dot(lightDir0, normal));
    float light1 = max(0.0, dot(lightDir1, normal));
    float lightAccum = min(1.0, (light0 + light1) * MINECRAFT_LIGHT_POWER + MINECRAFT_AMBIENT_LIGHT);
    return vec4(vec3(1.0, 1.0, 1.0) * lightAccum, 1.0);
}

void main() {
    gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;
    outTexCoord = gl_MultiTexCoord0.xy;
    outLightColor = texture2D(lightmapSampler, clamp(lightTexCoord / 256.0, vec2(0.5 / 16.0), vec2(15.5 / 16.0)));
    outVertexColor = minecraft_mix_light(light0, light1, normalize(normals));
    vertexDistance = length((gl_ModelViewMatrix * gl_Vertex).xyz);
}