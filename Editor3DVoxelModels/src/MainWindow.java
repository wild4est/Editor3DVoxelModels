import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;

/*
 * TODO: 
 * 	 - Отрисовка только лицевых граней
 * 	 - Выбор грани кубика
 * 	 - Отрисовка нового кубика на выбраной грани
 *   - Удаление выбранного кубика
 *   
 *   
 *   - Изменение цвета кубиков
 *   - Сохранение/загрузка модельки
 */


public class MainWindow implements GLEventListener{
	
	private GLU glu = new GLU();
	private static float fi=0;
	private static char side='o';
	private static float cube_size = 100.0f;
	private static ArrayList<Voxel> voxels = new ArrayList<>();
	
	
	
	private static float[][] coor_vec = new float[3][3];
	
	public static void main(String[] args) {
		
		coor_vec[0][0]=1; coor_vec[0][1]=0; coor_vec[0][2]=0;
		coor_vec[1][0]=0; coor_vec[1][1]=1; coor_vec[1][2]=0;
		coor_vec[2][0]=0; coor_vec[2][1]=0; coor_vec[2][2]=1;
		
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
	    
	    
	    frame.addKeyListener(new KeyAdapter() {
    	  	public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_Q) {	
                	fi = 0.005f;
                	side = 'X';
                	
                } else if(e.getKeyCode() == KeyEvent.VK_A) {
                	fi = -0.005f;
                	side = 'X';
                	
                }
                if(e.getKeyCode() == KeyEvent.VK_W) {
                	fi = 0.005f;
                	side = 'Y';
                	
                }else if(e.getKeyCode() == KeyEvent.VK_S) {
                	fi = -0.005f;
                	side = 'Y';
                	
                }
                
                if(e.getKeyCode() == KeyEvent.VK_E) {
                	fi = 0.005f;
                	side = 'Z';
                	
                }else if(e.getKeyCode() == KeyEvent.VK_D) {
                	fi = -0.005f;
                	side = 'Z';
                	
                }
                
                if(e.getKeyCode() == KeyEvent.VK_UP && cube_size<200) {
                	cube_size+=2;
                	
                }else if(e.getKeyCode() == KeyEvent.VK_DOWN && cube_size>10) {
                		cube_size-=2;
                	
                }
            }
    	  
            public void keyReleased(KeyEvent e) {
            	fi = 0;
            }
             
        });
	    
	    frame.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub	
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

	    	
	    });
	    
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
		
		//gl.glInitNames();
		
		gl.glClearColor(0.2f, 0.2f, 0.2f, 1f);
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT );
		gl.glLoadIdentity();
		gl.glTranslatef( 0f, 0f, -3.0f ); 
		
		Voxel cube = new Voxel(gl, cube_size, 46f, 139f, 87f);
		cube.setPos(0, 0, 0);
		//voxels.add(cube);
		
		Voxel cube2 = new Voxel(gl, cube_size, 46f, 139f, 87f);
		cube2.setPos(cube_size*2, 0, 0);
		//voxels.add(cube2);
		
		
		cube.rotate(coor_vec, fi, side);
		cube2.rotate(coor_vec, fi, side);
		
		cube.draw();
		cube2.draw();
		
		/*
		for(int i=0; i<voxels.size(); i++) {
			voxels.get(i).rotate(coor_vec, fi, side);	
		}
		for(int i=0; i<voxels.size(); i++) {
			voxels.get(i).draw();
				
		}*/
		
		
		
		
		//fi+=0.01f;
		
		//System.out.println("X:" + cube.getX() + "  Y:" + cube.getY());
		
		
		
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
