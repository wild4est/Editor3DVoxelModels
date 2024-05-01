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
	
	public float getZ() {
		return z_per;
	}
	
	public float[][] getCoor() {
		return coordinate;
	}
	
	public void printCoor() {
		for(int i=0; i<coordinate.length;i++) {
			System.out.println("X= " + coordinate[i][0] + "| Y= " + coordinate[i][1] + "| Z= " + coordinate[i][2]);
		}
		System.out.println("===============================");
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
	    
	    
	    gl.glBegin(GL2.GL_LINES);
	    gl.glColor3f(1,1,1);
	    
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
	
	public void rotate(float[][] coor_vec, float fi, char side) {
		cosF = (float)Math.cos(fi);
		sinF = (float)Math.sin(fi);
		
		int id_side1 = 0;
		int id_side2 = 1;
		
		float tmp1,tmp2,tmp3;
		
		
		switch(side) {
			case ('X'):
				id_side1 = 0;
				id_side2 = 1;
				break;
			case ('Y'):
				id_side1 = 0;
				id_side2 = 2;
				break;
			case ('Z'):
				id_side1 = 0;
				id_side2 = 1;
				break;
		}
		
		for(int i=0; i<3;i++) {
			tmp1 = coor_vec[id_side1][i];
			tmp2 = coor_vec[id_side2][i];
			
			coor_vec[id_side1][i] = tmp1*cosF - tmp2*sinF;
			coor_vec[id_side2][i] = tmp1*sinF + tmp2*cosF;
			
		}
		
		for(int i=0; i<coordinate.length;i++) {
			tmp1 = coordinate[i][0];
			tmp2 = coordinate[i][1];
			tmp3 = coordinate[i][2];
			
			coordinate[i][0] = coor_vec[0][0]*tmp1 + coor_vec[0][1]*tmp2 + coor_vec[0][2]*tmp3;
			coordinate[i][1] = coor_vec[1][0]*tmp1 + coor_vec[1][1]*tmp2 + coor_vec[1][2]*tmp3;
			coordinate[i][2] = coor_vec[2][0]*tmp1 + coor_vec[2][1]*tmp2 + coor_vec[2][2]*tmp3;
		}
		
		
	}
	

}
