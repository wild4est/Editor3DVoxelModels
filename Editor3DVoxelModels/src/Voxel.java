import com.jogamp.opengl.GL2;


public class Voxel {
	
	private GL2 gl;
	private float vox_size;
	private float x_per;
	private float y_per;
	private float z_per;
	private float Rcolor;
	private float Gcolor;
	private float Bcolor;
	private float cosF;
	private float sinF;
	private float[][] coordinate = new float[8][3];
	
	
	Voxel(GL2 gl2, float vs, float r, float g, float b){
		gl = gl2;
		vox_size = vs;
		
		Rcolor = r/255;
		Gcolor = g/255;
		Bcolor = b/255;
		
		x_per = 0;
		y_per = 0;
		z_per = 0;
		
		FillCoordinate();
	}
	
	public void setPos(float x, float y, float z) {
		x_per = x;
		y_per = y;
		z_per = z;
		
		FillCoordinate();
	}
	
	public void FillCoordinate() {
		coordinate[0][0] = x_per + vox_size; coordinate[0][1] = y_per + vox_size; coordinate[0][2]= z_per + vox_size; 
		coordinate[1][0] = x_per + vox_size; coordinate[1][1] = y_per + vox_size; coordinate[1][2]= z_per - vox_size; 
		coordinate[2][0] = x_per + vox_size; coordinate[2][1] = y_per - vox_size; coordinate[2][2]= z_per + vox_size; 
		coordinate[3][0] = x_per + vox_size; coordinate[3][1] = y_per - vox_size; coordinate[3][2]= z_per - vox_size; 
		coordinate[4][0] = x_per - vox_size; coordinate[4][1] = y_per + vox_size; coordinate[4][2]= z_per + vox_size; 
		coordinate[5][0] = x_per - vox_size; coordinate[5][1] = y_per + vox_size; coordinate[5][2]= z_per - vox_size; 
		coordinate[6][0] = x_per - vox_size; coordinate[6][1] = y_per - vox_size; coordinate[6][2]= z_per + vox_size; 
		coordinate[7][0] = x_per - vox_size; coordinate[7][1] = y_per - vox_size; coordinate[7][2]= z_per - vox_size; 
	}
	
	public float getX() {
		return x_per;
	}
	
	public float getY() {
		return y_per;
	}
	
	public void draw() {
		
	    
	    gl.glBegin(GL2.GL_QUADS);
	    gl.glColor3f(Rcolor,Gcolor,Bcolor);
	    
	    gl.glVertex3f((coordinate[4][0])/350, (coordinate[4][1])/350, (coordinate[4][2])/350);
	    gl.glVertex3f((coordinate[5][0])/350, (coordinate[5][1])/350, (coordinate[5][2])/350);
	    gl.glVertex3f((coordinate[7][0])/350, (coordinate[7][1])/350, (coordinate[7][2])/350);
	    gl.glVertex3f((coordinate[6][0])/350, (coordinate[6][1])/350, (coordinate[6][2])/350);
	    
	    gl.glVertex3f((coordinate[6][0])/350, (coordinate[6][1])/350, (coordinate[6][2])/350);
	    gl.glVertex3f((coordinate[7][0])/350, (coordinate[7][1])/350, (coordinate[7][2])/350);
	    gl.glVertex3f((coordinate[3][0])/350, (coordinate[3][1])/350, (coordinate[3][2])/350);
	    gl.glVertex3f((coordinate[2][0])/350, (coordinate[2][1])/350, (coordinate[2][2])/350);
	    
	    gl.glVertex3f((coordinate[4][0])/350, (coordinate[4][1])/350, (coordinate[4][2])/350);
	    gl.glVertex3f((coordinate[5][0])/350, (coordinate[5][1])/350, (coordinate[5][2])/350);
	    gl.glVertex3f((coordinate[0][0])/350, (coordinate[0][1])/350, (coordinate[0][2])/350);
	    gl.glVertex3f((coordinate[1][0])/350, (coordinate[1][1])/350, (coordinate[1][2])/350);
	    
	    gl.glVertex3f((coordinate[0][0])/350, (coordinate[0][1])/350, (coordinate[0][2])/350);
	    gl.glVertex3f((coordinate[1][0])/350, (coordinate[1][1])/350, (coordinate[1][2])/350);
	    gl.glVertex3f((coordinate[3][0])/350, (coordinate[3][1])/350, (coordinate[3][2])/350);
	    gl.glVertex3f((coordinate[2][0])/350, (coordinate[2][1])/350, (coordinate[2][2])/350);
	    
	    gl.glVertex3f((coordinate[0][0])/350, (coordinate[0][1])/350, (coordinate[0][2])/350);
	    gl.glVertex3f((coordinate[2][0])/350, (coordinate[2][1])/350, (coordinate[2][2])/350);
	    gl.glVertex3f((coordinate[6][0])/350, (coordinate[6][1])/350, (coordinate[6][2])/350);
	    gl.glVertex3f((coordinate[4][0])/350, (coordinate[4][1])/350, (coordinate[4][2])/350);
	    
	    gl.glVertex3f((coordinate[1][0])/350, (coordinate[1][1])/350, (coordinate[1][2])/350);
	    gl.glVertex3f((coordinate[3][0])/350, (coordinate[3][1])/350, (coordinate[3][2])/350);
	    gl.glVertex3f((coordinate[7][0])/350, (coordinate[7][1])/350, (coordinate[7][2])/350);
	    gl.glVertex3f((coordinate[5][0])/350, (coordinate[5][1])/350, (coordinate[5][2])/350);
	    
	    gl.glEnd();
	    
	}
	
	public void rotate(float fi) {
		cosF = (float)Math.cos(fi);
		sinF = (float)Math.sin(fi);
		for (int i=0; i<coordinate.length; i++) {
			float tmp1 = coordinate[i][0];
			float tmp2 = coordinate[i][1];
			coordinate[i][0] = tmp1*cosF - tmp2*sinF; coordinate[i][1] = tmp1*sinF + tmp2*cosF;
		}
	}
	

}
