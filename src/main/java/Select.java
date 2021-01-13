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
public class Select extends JFrame implements ActionListener {
    String a = "";
    String b = "";
    JButton jb = new JButton("open file");
    JButton jb1 = new JButton("choose path");
    JButton jb2 = new JButton("ok");
    JLabel jl = new JLabel();
    JLabel jl1 = new JLabel();

    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        Select select = new Select();
        select.M4();
    }

    public void M4() {
        JFrame frame = new JFrame("ExcelToImg");
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
        //创建JPanel对象
        JPanel jp = new JPanel();
        jb.setActionCommand("open");
        //设置按钮颜色
        jb.setBackground(Color.white);
        //建立容器使用边界布局
        jp.add(jb);
        jp.add(jl);

        jb1.setActionCommand("choose");
        //设置按钮颜色
        jb1.setBackground(Color.white);
        //建立容器使用边界布局
        jp.add(jb1);
        jp.add(jl1);

        jb2.setActionCommand("ok");
        //设置按钮颜色
        jb2.setBackground(Color.white);
        jp.add(jb2);

        jb.addActionListener(this);
        jb1.addActionListener(this);
        jb2.addActionListener(this);

        jp.setLayout(new GridLayout(3,2, 20, 20));
        frame.add(jp);
        frame.setSize(333, 288);
        frame.setLocation(200, 200);
        frame.setBounds(300, 200, 600, 300);
        //显示窗口true
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("open")) {
            JFileChooser jf = new JFileChooser();
            //显示打开的文件对话框
            jf.showOpenDialog(this);
            jf.setFileSelectionMode(JFileChooser.FILES_ONLY);
            //使用文件类获取选择器选择的文件
            File f = jf.getSelectedFile();
            if (f.exists() && f.getName().endsWith(".xlsx")) {
                //返回路径名
                String s = f.getAbsolutePath();
                a = s;
                jl.setText(a);
            } else {
                String s = f.getAbsolutePath();
                a = s;
                jl.setText(a);
                JOptionPane.showMessageDialog(this, "请选择后缀为.xlsx的文件", "error", JOptionPane.WARNING_MESSAGE);
            }
        }
        if (e.getActionCommand().equals("choose")) {
            JFileChooser jf = new JFileChooser();
            jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            //显示打开的文件对话框
            jf.showOpenDialog(this);
            //使用文件类获取选择器选择的文件
            File f = jf.getSelectedFile();
            //返回路径名
            String s = f.getAbsolutePath();
            b = s;
            jl1.setText(b);
        }
        if (e.getActionCommand().equals("ok")) {
            if ("".equals(a)||"".equals(b)){
                JOptionPane.showMessageDialog(this, "请选择文件路径以及保存路径", "error", JOptionPane.WARNING_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(this, "ok", "error", JOptionPane.WARNING_MESSAGE);
            }
        }

    }
}

