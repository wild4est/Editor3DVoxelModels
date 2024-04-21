import javax.swing.JFrame;

import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;

public class MainWindow implements GLEventListener{

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		
	}

}
