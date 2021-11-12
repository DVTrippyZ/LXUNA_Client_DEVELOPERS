#version 110

varying vec4 outColor;
varying vec2 outTexCoords;
varying vec2 outLightCoords;
varying float outVertexDistance;

void main()
{
    outColor = gl_Color;
    outTexCoords = gl_MultiTexCoord0.xy;
    outLightCoords = gl_MultiTexCoord1.xy / 255.0;
    gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;
    vec4 eyePos = gl_ModelViewMatrix * gl_Vertex;
    outVertexDistance = abs(eyePos.z/eyePos.w);
}
