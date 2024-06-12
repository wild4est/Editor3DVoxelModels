import com.jogamp.opengl.GL2;

public class VoxelSide {
	private GL2 gl;
	private float[][] vertexes = new float[4][3];
	private boolean IsVis;
	
	VoxelSide(GL2 gl2, float[] v1, float[] v2, float[] v3, float[] v4){
		gl = gl2;
		
		for(int i=0; i<3; i++) {
			vertexes[0][i] = v1[i];
			vertexes[1][i] = v2[i];
			vertexes[2][i] = v3[i];
			vertexes[3][i] = v4[i];
		}
		
		
		
		
		
		
	}
	
	public void draw() {
		//gl.glColor3f(1, 0, 1);
		
		for(int i=0; i<4; i++) {
			gl.glVertex3f(vertexes[i][0]/350, vertexes[i][1]/350, vertexes[i][2]/350);
		}
		
		/*
		gl.glVertex3f( 0f, 0f, 0f);
		gl.glVertex3f( 100/350f, 0f, 0f);
		gl.glVertex3f( 100/350f, 100/350f, 0f);
		gl.glVertex3f( 0f, 100/350f, 0f);
		*/
		//gl.glEnd();
		
	}
	
	
}
