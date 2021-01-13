import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Demo class
 *
 * @author wym
 * @date 2021/1/12
 */
public class Demo extends JFrame implements ActionListener {
    String a = "";
    String b = "";
    JButton jb = new JButton("open file");
    JButton jb1 = new JButton("choose path");

    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        Demo demo = new Demo();
        demo.M4();
    }

    public  void  M4() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        jb.setActionCommand("open");
        //设置按钮颜色
        jb.setBackground(Color.white);
        //建立容器使用边界布局
        this.getContentPane().add(jb, BorderLayout.NORTH);

        jb1.setActionCommand("choose");
        //设置按钮颜色
        jb1.setBackground(Color.white);
        //建立容器使用边界布局
        this.getContentPane().add(jb1, BorderLayout.SOUTH);

        jb.addActionListener(this);
        jb1.addActionListener(this);
        this.setTitle("Excel2Img");
        this.setSize(333, 288);
        this.setLocation(200, 200);
        //显示窗口true
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("open")) {
            JFileChooser jf = new JFileChooser();
            //显示打开的文件对话框
            jf.showOpenDialog(this);
            jf.setFileSelectionMode(JFileChooser.FILES_ONLY);
            File file=new File("D:/pic");
            if(!file.exists()){//如果文件夹不存在
                file.mkdir();//创建文件夹
            }
            //使用文件类获取选择器选择的文件
            File f = jf.getSelectedFile();
            if (f.exists()&&f.getName().endsWith(".xlsx")){
                //返回路径名
                String s = f.getAbsolutePath();
                //JOptionPane弹出对话框类，显示绝对路径名
                JOptionPane.showMessageDialog(this, s, "path", JOptionPane.WARNING_MESSAGE);
                a=s;
            }else {
                JOptionPane.showMessageDialog(this, "请选择后缀为.xlsx的文件", "error", JOptionPane.WARNING_MESSAGE);
            }
        }
        if (e.getActionCommand().equals("choose")) {
            System.out.println("aaaaaaaaaaaa");
        }

    }

}

