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
	//几个功能的按钮
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
		//file内容转化成String的一个类
		private TestFile tf;
		private SaveFile sf;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand().equals("开始分词")){
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
//				System.out.println("开始分词被点击了");
				
			}else if(e.getActionCommand().equals("导入文件")){
				fileChooser.showOpenDialog(null);
				importFile = fileChooser.getSelectedFile();
				String str = importFile.getPath();
				tf = new TestFile(str);
				oldText.setText(tf.LoadFile());
//				System.out.println("导入文件被点击了");
			}else if(e.getActionCommand().equals("导出文件")){
				fileChooser.showSaveDialog(null);
				exportFile = fileChooser.getSelectedFile();
				sf = new SaveFile(exportFile, newText.getText());
				sf.saveFile();
//				System.out.println("导出文件被点击了");
			}else if(e.getActionCommand().equals("加载新词典")){
				fileChooser.showOpenDialog(null);
				File dicFile = fileChooser.getSelectedFile();
				Dictionary newDic = new Dictionary(dicFile.getPath()); 
				seg.resetDic(newDic);
				System.out.println("加载新词典被点击了");
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
	
	
		
		segmentation = new JButton("开始分词");
		segmentation.addActionListener(segAction);
		segmentation.setBounds(249, 199, 105, 23);
		frame.getContentPane().add(segmentation);
		
		importFile = new JButton("导入文件");
		importFile.addActionListener(segAction);
		importFile.setBounds(81, 9, 93, 23);
		frame.getContentPane().add(importFile);
		
		exportFile = new JButton("导出文件");
		exportFile.addActionListener(segAction);
		exportFile.setBounds(255, 9, 93, 23);
		frame.getContentPane().add(exportFile);
		
		loadDic = new JButton("加载新词典");
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
