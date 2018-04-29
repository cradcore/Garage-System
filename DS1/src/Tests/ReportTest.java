package Tests;

import java.awt.Container;
import org.junit.*;

import ParkingGarageSystem.Garage;
import ParkingGarageSystem.Report;

import static org.junit.Assert.*;


public class ReportTest {

	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ReportTest.class);
	}

	@Test
	public void testReport_1()
		throws Exception {
		Garage g = new Garage(1);
		Report result = new Report(g);
		assertNotNull(result);
	}

	@Test
	public void testGetPanel_1()
		throws Exception {
		Report fixture = new Report(new Garage(1));
		Container result = fixture.getPanel();
		assertNotNull(result);
		assertEquals(false, result.isFocusTraversalPolicyProvider());
		assertEquals(false, result.isFocusTraversalPolicySet());
		assertEquals(14, result.countComponents());
		assertEquals(0.5f, result.getAlignmentX(), 1.0f);
		assertEquals(0.5f, result.getAlignmentY(), 1.0f);
		assertEquals(14, result.getComponentCount());
		assertEquals(null, result.getFocusTraversalPolicy());
		assertEquals(false, result.isFocusCycleRoot());
		assertEquals(false, result.isValidateRoot());
		assertEquals("javax.swing.JPanel[null.contentPane,0,0,0x0,invalid,layout=java.awt.GridBagLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=9,maximumSize=,minimumSize=,preferredSize=]", result.toString());
		assertEquals("null.contentPane", result.getName());
		assertEquals(true, result.isOpaque());
		assertEquals(false, result.isValid());
		assertEquals(0, result.getY());
		assertEquals(true, result.isEnabled());
		assertEquals(0, result.getHeight());
		assertEquals(0, result.getX());
		assertEquals(false, result.isShowing());
		assertEquals(false, result.hasFocus());
		assertEquals(true, result.isVisible());
		assertEquals(0, result.getWidth());
		assertEquals(null, result.getGraphics());
		assertEquals(null, result.getDropTarget());
		assertEquals(true, result.getFocusTraversalKeysEnabled());
		assertEquals(false, result.getIgnoreRepaint());
		assertEquals(null, result.getInputMethodRequests());
		assertEquals(null, result.getMousePosition());
		assertEquals(null, result.getPeer());
		assertEquals(true, result.isBackgroundSet());
		assertEquals(false, result.isCursorSet());
		assertEquals(false, result.isDisplayable());
		assertEquals(true, result.isDoubleBuffered());
		assertEquals(false, result.isFocusOwner());
		assertEquals(true, result.isFocusTraversable());
		assertEquals(true, result.isFocusable());
		assertEquals(true, result.isFontSet());
		assertEquals(true, result.isForegroundSet());
		assertEquals(false, result.isLightweight());
		assertEquals(false, result.isMaximumSizeSet());
		assertEquals(false, result.isMinimumSizeSet());
		assertEquals(false, result.isPreferredSizeSet());
		assertEquals(false, result.requestFocusInWindow());
	}


}