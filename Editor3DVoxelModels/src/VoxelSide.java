import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;

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
	
	
	public boolean checkHit(GL2 gl, GLU glu, float x, float y) {
		double angle1 = getAngle(gl, glu, vertexes[0], vertexes[1], x, y);
		double angle2 = getAngle(gl, glu, vertexes[1], vertexes[2], x, y);
		double angle3 = getAngle(gl, glu, vertexes[2], vertexes[3], x, y);
		double angle4 = getAngle(gl, glu, vertexes[3], vertexes[0], x, y);
		
		System.out.println("an1 = " + angle1 + "|  an2 = " + angle2 + "|  an3 = " + angle3 + "|  an4 = " + angle4);
		System.out.println("Sum ang = " + (angle1+angle2+angle3+angle4) + " | pi=" + 2*Math.PI);
		System.out.println();
		
		double sum = angle1+angle2+angle3+angle4;
		double PI2 = 2*Math.PI;
		
		if(Math.abs(sum-PI2) < 0.000000001) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public double getAngle(GL2 gl, GLU glu,float[] vertex1, float[] vertex2, float x, float y) {
		double[] posV1 =  getVertexPosOnScreen(gl, glu, vertex1);
		double[] posV2 =  getVertexPosOnScreen(gl, glu, vertex2);
		
		double a =  getDistanceBetweenTwoPoints(posV1[0], posV1[1], posV2[0], posV2[1]);
		double b =  getDistanceBetweenTwoPoints(posV2[0], posV2[1], x, y);
		double c =  getDistanceBetweenTwoPoints(x, y, posV1[0], posV1[1]);
		
		System.out.println("V1:   x=" + posV1[0] + "  y=" + posV1[1]);
		System.out.println("V2:   x=" + posV2[0] + "  y=" + posV2[1]);
		System.out.println("V3:   x=" + x + "  y=" + y);
		System.out.println();
		System.out.println("P12 = " + a);
		System.out.println("P20 = " + b);
		System.out.println("P01 = " + c);
		System.out.println();
		
		
		double cos_ang = (b*b + c*c - a*a)/(2*c*b);
		System.out.println("cos = " + cos_ang);
		System.out.println("acos = " + Math.acos(cos_ang));
		System.out.println();
		return Math.acos(cos_ang);
	}
	
	public double getDistanceBetweenTwoPoints(double x1, double y1, double x2, double y2) {
		double a = x1-x2;
		double b = y1-y2;
		double c = a*a + b*b;
		c = Math.sqrt(c);
		return c; 
	}
	
	
	public double[] getVertexPosOnScreen(GL2 gl, GLU glu, float[] vertex) {
		int viewport[] = new int[4];
		double modelview[] = new double[16];
		double projection[] = new double[16];
		float winX, winY, winZ;
		float pos[] = new float[4];
		double vcoord[] = new double[4];
		
		winX = vertex[0];
		winY = vertex[1];
		winZ = vertex[2];
		
		

		gl.glGetDoublev( GL2.GL_MODELVIEW_MATRIX, modelview, 0 );
		gl.glGetDoublev( GL2.GL_PROJECTION_MATRIX, projection, 0 );
		gl.glGetIntegerv( GL2.GL_VIEWPORT, viewport, 0 );
		boolean test = glu.gluProject( winX/350, winY/350, winZ/350, modelview, 0, projection, 0, viewport, 0, vcoord, 0);
		System.out.println("v1 = " + vertex[0]/350);
		System.out.println("v2 = " + vertex[1]/350);
		System.out.println("v3 = " + vertex[2]/350);
		
		System.out.println("Test = " + test);
		return vcoord;
		
	
	}
	
	
}
