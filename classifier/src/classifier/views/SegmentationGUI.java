package classifier.views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import classifier.file.pretreatment.SaveFile;
import classifier.file.pretreatment.TestFile;
import classifier.word.dictionary.Dictionary;
import classifier.word.segmentation.Segmentation;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.ComponentOrientation;
import java.awt.Cursor;

import javax.swing.JComboBox;

import java.awt.Scrollbar;
public class SegmentationGUI{

	private JFrame frame;
	private JScrollPane oldTextScroll;
	private JScrollPane newTextScroll;
	private JTextArea oldText;
	private JTextArea newText;
	//�������ܵİ�ť
	private JButton segmentation;
	private JButton importFile;
	private JButton exportFile;
	private JButton loadDic;	
	
	private SegmentationAction segAction = new SegmentationAction(); 
	
	
	
	private class SegmentationAction implements ActionListener{
		
		private Segmentation seg = new Segmentation();
		private Vector<String> list = new Vector<>();
		private JFileChooser fileChooser = new JFileChooser();
		private File importFile;
		private File exportFile;
		//file����ת����String��һ����
		private TestFile tf;
		private SaveFile sf;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals("��ʼ�ִ�")){
				String str = "";
				list.clear();
//				System.out.println(oldText.getText());
				seg.setFileString(oldText.getText());
				list = seg.starSeg();
				for(int i = 0;i < list.size(); i++){
					str += list.get(i)+" / ";
//					System.out.println(list.get(i));
				}
				newText.setText(str);
//				System.out.println("��ʼ�ִʱ������");
				
			}else if(e.getActionCommand().equals("�����ļ�")){
				fileChooser.showOpenDialog(null);
				importFile = fileChooser.getSelectedFile();
				String str = importFile.getPath();
				tf = new TestFile(str);
				oldText.setText(tf.LoadFile());
//				System.out.println("�����ļ��������");
			}else if(e.getActionCommand().equals("�����ļ�")){
				fileChooser.showSaveDialog(null);
				exportFile = fileChooser.getSelectedFile();
				sf = new SaveFile(exportFile, newText.getText());
				sf.saveFile();
//				System.out.println("�����ļ��������");
			}else if(e.getActionCommand().equals("�����´ʵ�")){
				fileChooser.showOpenDialog(null);
				File dicFile = fileChooser.getSelectedFile();
				Dictionary newDic = new Dictionary(dicFile.getPath()); 
				seg.resetDic(newDic);
				System.out.println("�����´ʵ䱻�����");
			}
			
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SegmentationGUI window = new SegmentationGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SegmentationGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frame.setTitle("\u4E2D\u6587\u81EA\u52A8\u5206\u8BCD\u7CFB\u7EDF");
		frame.setVisible(true);
		frame.setBounds(100, 100, 622, 442);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
	
		
		segmentation = new JButton("��ʼ�ִ�");
		segmentation.addActionListener(segAction);
		segmentation.setBounds(249, 199, 105, 23);
		frame.getContentPane().add(segmentation);
		
		importFile = new JButton("�����ļ�");
		importFile.addActionListener(segAction);
		importFile.setBounds(81, 9, 93, 23);
		frame.getContentPane().add(importFile);
		
		exportFile = new JButton("�����ļ�");
		exportFile.addActionListener(segAction);
		exportFile.setBounds(255, 9, 93, 23);
		frame.getContentPane().add(exportFile);
		
		loadDic = new JButton("�����´ʵ�");
		loadDic.addActionListener(segAction);
		loadDic.setBounds(429, 9, 105, 23);
		frame.getContentPane().add(loadDic);
		
		oldTextScroll = new JScrollPane();
		oldTextScroll.setBounds(28, 44, 555, 141);
		frame.getContentPane().add(oldTextScroll);
		
		oldText = new JTextArea();
		oldText.setLineWrap(true);
		oldText.setWrapStyleWord(true);
		oldTextScroll.setViewportView(oldText);
		
		newTextScroll = new JScrollPane();
		newTextScroll.setBounds(28, 252, 555, 141);
		frame.getContentPane().add(newTextScroll);
		
		newText = new JTextArea();
		newText.setLineWrap(true);
		newText.setWrapStyleWord(true);
		newTextScroll.setViewportView(newText);
		
	}
}
