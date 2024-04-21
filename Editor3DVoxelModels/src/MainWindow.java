import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;

public class MainWindow implements GLEventListener{
	
	private GLU glu = new GLU();

	public static void main(String[] args) {
		final GLProfile profile = GLProfile.get( GLProfile.GL2 );
	    GLCapabilities capabilities = new GLCapabilities( profile );
	      
	    final GLCanvas glcanvas = new GLCanvas( capabilities );
	    MainWindow window = new MainWindow();
			
	    glcanvas.addGLEventListener( window );
	    glcanvas.setSize( 700, 700 );
			
	    final JFrame frame = new JFrame ( "Voxel Are Cool" );
	    frame.getContentPane().add( glcanvas );
	    frame.setSize( frame.getContentPane().getPreferredSize() );
	    frame.setVisible( true );
	    
	    final FPSAnimator animator = new FPSAnimator(glcanvas, 300,true);
		
	    animator.start();

	}

	@Override
	public void init(GLAutoDrawable drawable) {
		final GL2 gl = drawable.getGL().getGL2();
		gl.glShadeModel( GL2.GL_SMOOTH );
	    gl.glClearColor( 0f, 0f, 0f, 0f );
	    gl.glClearDepth( 1.0f );
	    gl.glEnable( GL2.GL_DEPTH_TEST );
	    gl.glDepthFunc( GL2.GL_LEQUAL );
	    gl.glHint( GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST );
		
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		final GL2 gl = drawable.getGL().getGL2();
		
		gl.glClearColor(0.2f, 0.2f, 0.2f, 1f);
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT );
		gl.glLoadIdentity();
		gl.glTranslatef( 0f, 0f, -3.0f ); 
		
		Voxel cube = new Voxel(gl, 10f, 46f, 139f, 87f);
		cube.draw(0, 0, 0);
	      
	      
		
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		final GL2 gl = drawable.getGL().getGL2();
		if( height <= 0 ) height = 1;
		
		final float h = ( float ) width  / ( float ) height;
		gl.glViewport( 0, 0, width, height );
		gl.glMatrixMode( GL2.GL_PROJECTION );
		gl.glLoadIdentity();
		
		glu.gluPerspective( 45.0f, h, 1.0, 20.0 );
		gl.glMatrixMode( GL2.GL_MODELVIEW );
		gl.glLoadIdentity();
		
	}

}
