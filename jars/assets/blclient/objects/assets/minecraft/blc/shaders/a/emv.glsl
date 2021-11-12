#version 150
const int MAX_JOINTS = 20;
const int MAX_WEIGHTS = 4;

in vec4 position;
in vec3 normal;
in vec2 texCoord;
in ivec4 jointIndices;
in vec4 jointWeights;

out vec3 outNormal;
out vec2 outTexCoord;
out float vertexDistance;

uniform mat4 projectionMatrix;
uniform mat4 modelViewMatrix;
uniform mat4 jointMatrix[MAX_JOINTS];

void main()
{

    vec4 resultVertex = vec4(0);
    vec3 resultNormal = vec3(0);

    int count = 0;

    for (int w = 0; w < MAX_WEIGHTS; w++)
    {
        float weight = jointWeights[w];

        if (weight > 0)
        {
            int index = jointIndices[w];
            mat4 matrix = jointMatrix[index];
            resultVertex += matrix * vec4(position.xyz, 1) * weight;

            resultNormal +=  mat3(matrix) * normal * weight;
            count++;
        }
    }

    if (count == 0) {
        resultVertex = vec4(position.xyz, 1);
        resultNormal = normal;
    }

    outNormal = resultNormal;
    outTexCoord = texCoord;
    vertexDistance = length((modelViewMatrix * position).xyz);

    gl_Position = projectionMatrix * modelViewMatrix * resultVertex;
}