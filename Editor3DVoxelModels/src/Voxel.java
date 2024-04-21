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
	
	
	Voxel(GL2 gl2, float vs, float r, float g, float b){
		gl = gl2;
		vox_size = vs;
		
		Rcolor = r/255;
		Gcolor = g/255;
		Bcolor = b/255;
	}
	
	public void draw(float x, float y, float z) {
		x_per = x;
		y_per = y;
		z_per = z;
		
		gl.glBegin(GL2.GL_QUADS);
	    gl.glColor3f(Rcolor,Gcolor,Bcolor);
	    gl.glVertex3f((vox_size + x_per)/350, (vox_size + y_per)/350, (-vox_size + z_per)/350);
	    gl.glVertex3f( (-vox_size + x_per)/350, (vox_size + y_per)/350,( -vox_size + z_per)/350);
	    gl.glVertex3f( (-vox_size + x_per)/350, (vox_size + y_per)/350,( vox_size + z_per)/350 );
	    gl.glVertex3f( (vox_size + x_per)/350, (vox_size + y_per)/350, (vox_size + z_per)/350 );
	    
	    gl.glVertex3f( (vox_size + x_per)/350, (-vox_size + y_per)/350, (vox_size + z_per)/350 );
	    gl.glVertex3f( (-vox_size + x_per)/350,( -vox_size + y_per)/350,( vox_size + z_per)/350);
	    gl.glVertex3f( (-vox_size + x_per)/350,( -vox_size + y_per)/350,( -vox_size + z_per)/350 );
	    gl.glVertex3f( (vox_size + x_per)/350, (-vox_size + y_per)/350, (-vox_size + z_per)/350 ); 

	    gl.glVertex3f( (vox_size + x_per)/350, (vox_size + y_per)/350, (vox_size + z_per)/350 );
	    gl.glVertex3f( (-vox_size + x_per)/350,( vox_size + y_per)/350, (vox_size + z_per)/350 );
	    gl.glVertex3f( (-vox_size + x_per)/350,( -vox_size + y_per)/350,( vox_size + z_per)/350 );
	    gl.glVertex3f( (vox_size + x_per)/350, (-vox_size + y_per)/350, (vox_size + z_per)/350 ); 

	    gl.glVertex3f( (vox_size + x_per)/350, (-vox_size + y_per)/350, (-vox_size + z_per)/350);
	    gl.glVertex3f( (-vox_size + x_per)/350, (-vox_size + y_per)/350, (-vox_size + z_per)/350 );
	    gl.glVertex3f( (-vox_size + x_per)/350, (vox_size + y_per)/350, (-vox_size + z_per)/350 );
	    gl.glVertex3f( (vox_size + x_per)/350, (vox_size + y_per)/350, (-vox_size + z_per)/350 );

	    gl.glVertex3f( (-vox_size + x_per)/350, (vox_size + y_per)/350, (vox_size + z_per)/350 );
	    gl.glVertex3f( (-vox_size + x_per)/350, (vox_size + y_per)/350, (-vox_size + z_per)/350 );
	    gl.glVertex3f( (-vox_size + x_per)/350, (-vox_size + y_per)/350, (-vox_size + z_per)/350 );
	    gl.glVertex3f( (-vox_size + x_per)/350, (-vox_size + y_per)/350, (vox_size + z_per)/350 ); 

	    gl.glVertex3f( (vox_size + x_per)/350,( vox_size + y_per)/350, (-vox_size + z_per)/350 );
	    gl.glVertex3f( (vox_size + x_per)/350,( vox_size + y_per)/350, (vox_size + z_per)/350 );
	    gl.glVertex3f( (vox_size + x_per)/350,( -vox_size + y_per)/350, (vox_size + z_per)/350 );
	    gl.glVertex3f(( vox_size + x_per)/350,( -vox_size + y_per)/350,( -vox_size + z_per)/350 );
	    gl.glEnd();
	}
	

}
