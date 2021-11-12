#version 150

in vec3 position;
in vec2 texCoord;

out vec2 outTexCoord;
out float vertexDistance;

uniform mat4 projectionMatrix;
uniform mat4 modelViewMatrix;

void main()
{
    outTexCoord = texCoord;
    vertexDistance = length((modelViewMatrix * vec4(position, 1.0)).xyz);

    gl_Position = projectionMatrix * modelViewMatrix * vec4(position, 1.0);
}
