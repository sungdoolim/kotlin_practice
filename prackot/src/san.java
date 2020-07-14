import java.awt.*;

import java.awt.event.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;

import javax.swing.*;

public class san extends JFrame implements ActionListener {

    // North
    String birth;
    JPanel topPane = new JPanel();


    JButton prevBtn = new JButton("◀");

    JButton nextBtn = new JButton("▶");

    JButton dayBtn = new JButton();

    JButton qjq = new JButton("생일입력");

    JLabel yearLbl = new JLabel("년");

    JLabel monthLbl = new JLabel("월");

    JComboBox<Integer> yearCombo = new JComboBox<Integer>();

    DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer>();

    JComboBox<Integer> monthCombo = new JComboBox<Integer>();

    DefaultComboBoxModel<Integer> monthModel = new DefaultComboBoxModel<Integer>();

    // Center

    JPanel centerPane = new JPanel(new BorderLayout());

    JPanel titlePane = new JPanel(new GridLayout(1, 7));

    String titleStr[] = { "일", "월", "화", "수", "목", "금", "토" };

    JPanel datePane = new JPanel(new GridLayout(0, 7));
    JTextArea jt=new JTextArea(20,20);
    Calendar now;

    int year, month, date;

    public san() {

        super("Albabee");


        topPane.add(jt);//---------------------------------------------------------------
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // 자원 해제 후 종료

        now = Calendar.getInstance(); // 현재 날짜

        year = now.get(Calendar.YEAR);

        month = now.get(Calendar.MONTH) + 1;

        date = now.get(Calendar.DATE);

        topPane.add(qjq);
        topPane.add(prevBtn);

        for (int i = year - 100; i <= year + 50; i++) {

            yearModel.addElement(i);

        }

        yearCombo.setModel(yearModel);

        yearCombo.setSelectedItem(year); // 현재 년도 선택

        topPane.add(yearCombo);

        topPane.add(yearLbl);




        for (int i = 1; i <= 12; i++) {

            monthModel.addElement(i);

        }

        monthCombo.setModel(monthModel);

        monthCombo.setSelectedItem(month); // 현재 월 선택

        topPane.add(monthCombo);

        topPane.add(monthLbl);

        topPane.add(nextBtn);



        topPane.setBackground(new Color(255, 255, 0));

        add(topPane, "North");

        // Center

        titlePane.setBackground(Color.pink);

        for (int i = 0; i < titleStr.length; i++) {

            JLabel lbl = new JLabel(titleStr[i], JLabel.CENTER);

            if (i == 0) {

                lbl.setForeground(Color.red);

            } else if (i == 6) {

                lbl.setForeground(Color.blue);

            }

            titlePane.add(lbl);

        }

        centerPane.add(titlePane, "North");

        // 날짜 출력

        dayPrint(year, month);

        centerPane.add(datePane, "Center");

        add(centerPane, "Center");

        setSize(400, 300);

        setVisible(true);

        prevBtn.addActionListener(this);

        nextBtn.addActionListener(this);

        yearCombo.addActionListener(this);

        monthCombo.addActionListener(this);



        qjq.addActionListener(this);

        dayBtn.addActionListener(this);
    }

    // Overring

    public void actionPerformed(ActionEvent ae) {

        Object obj = ae.getSource();

        if (obj instanceof JButton) {

            JButton eventBtn = (JButton) obj;

            int yy = (Integer) yearCombo.getSelectedItem();

            int mm = (Integer) monthCombo.getSelectedItem();

            if (eventBtn.equals(prevBtn)) { // 전달
                topPane.setBackground(new Color((int)(Math.random()*255), (int)(Math.random()*255),(int)(Math.random()*255)));
                if (mm == 1) {

                    yy--;
                    mm = 12;

                } else {

                    mm--;

                }

            } else if (eventBtn.equals(nextBtn)) { // 다음달

                topPane.setBackground(new Color((int)(Math.random()*255), (int)(Math.random()*255),(int)(Math.random()*255)));
                if (mm == 12) {

                    yy++;
                    mm = 1;

                } else {

                    mm++;

                }

            }

            yearCombo.setSelectedItem(yy);

            monthCombo.setSelectedItem(mm);

            if (qjq == obj) {
                birth = JOptionPane.showInputDialog(this, "생일을  입력하세요!");

            }

        }

        else if (obj instanceof JComboBox) { // 콤보박스 이벤트 발생시

            createDayStart();

        }
    }

    public void createDayStart() {

        datePane.setVisible(false); // 패널 숨기기

        datePane.removeAll(); // 날짜 출력한 라벨 지우기
        topPane.setBackground(new Color((int)(Math.random()*255), (int)(Math.random()*255),(int)(Math.random()*255)));
        dayPrint((Integer) yearCombo.getSelectedItem(), (Integer) monthCombo.getSelectedItem());

        datePane.setVisible(true); // 패널 재출력

    }

    public void dayPrint(int y, int m) {

        Calendar cal = Calendar.getInstance();

        cal.set(y, m - 1, 1); // 출력할 첫날의 객체 만든다.

        int week = cal.get(Calendar.DAY_OF_WEEK); // 1일에 대한 요일 일요일 : 0

        int lastDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 그 달의 마지막 날

        for (int i = 1; i < week; i++) { // 날짜 출력 전까지의 공백 출력
            datePane.add(new JLabel(" "));

        }

        for (int i = 1; i <= lastDate; i++) {

            JButton dayBtn = new JButton(String.valueOf(i));

            cal.set(y, m - 1, i);

            int outWeek = cal.get(Calendar.DAY_OF_WEEK);

            if (outWeek == 1) {

                dayBtn.setForeground(Color.red);

            } else if (outWeek == 7) {

                dayBtn.setForeground(Color.BLUE);

            }

            datePane.add(dayBtn);
            dayBtn.addActionListener(
                    new MyActionListener((Integer)yearCombo.getSelectedItem(),(Integer)monthCombo.getSelectedItem(),birth,0,jt));
        }
    }

    public static void main(String[] args) {
        new san();

    }
}

class MyActionListener implements ActionListener {

    int year;
    int month;
    int index;
    String birth;
    JTextArea jt;

    MyActionListener(int a, int b, String birth, int c,JTextArea jt) {
        year = a;
        month = b;
        index = c;
        this.birth = birth;
        this.jt=jt;
    }

    @Override
    public void actionPerformed(ActionEvent e) {




        String k = (year + "년 " + month + "월" + e.getActionCommand() + "일 입니다.").toString();
        System.out.println(year + "년 " + month + "월" + e.getActionCommand() + "일 입니다.");

        //System.out.println(birth.length());
        int y = Integer.parseInt(birth.substring(0, 4));
        int m = Integer.parseInt(birth.substring(4, 6));
        int d = Integer.parseInt(birth.substring(6));
String cra=null;
        try {
           cra= crawl(month,e.getActionCommand());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        System.out.print("내가 태어난지 " + (year - y) + "년");
        System.out.print(month - m + " 개월 ");
        System.out.print(Math.abs(Integer.parseInt(e.getActionCommand().toString()) - d) + "일 차이 입니다.");
        String dd = ("\n내가 태어난지 " + (year - y) + "년").toString() + (month - m + " 개월 ").toString() +
                (Math.abs(Integer.parseInt(e.getActionCommand().toString()) - d) + "일 차이 입니다.").toString();
        JOptionPane.showMessageDialog(null, k + dd, "kimsan", JOptionPane.INFORMATION_MESSAGE);
      String []sp;
       // int i=0;
        int cl=cra.length();
        System.out.println("cl = "+cl);
        System.out.println("cra = "+cra);

        int k1=cra.indexOf("<div class=\"tit_box\">");
        System.out.println("k1 = "+k1);



        String sub=cra.substring(k1);
        int k2=sub.indexOf("</div>");
        sub=sub.substring(0,k2);
        k1=sub.indexOf("urlencode(this.href));\"> ");
        //12
        k2=sub.indexOf("</a>");
        sub=sub.substring(k1+25,k2);
        System.out.println("sub = "+sub);
        while(sub.contains("<strong>")){
            System.out.println(1);
            sub=sub.replaceAll("<strong>"," ");
            sub=sub.replaceAll("</strong>"," ");
        }
        System.out.println("result: "+sub);

System.out.println(sub);



            jt.append(sub);


    }


    public String crawl(int m,String e) throws MalformedURLException, IOException {
            int ee=Integer.parseInt(e);
            //String target="https://www.google.com/search?q=who+is+born+on+february+14th";
//
            //String target="https://search.naver.com/search.naver?query="+m+"월+"+ee+"일생+위인은+누구?";
            String target="https://search.naver.com/search.naver?where=kdic&query="+m+"월+"+ee+"일생+위인은+누구?";
            HttpURLConnection con=(HttpURLConnection) new URL(target).openConnection();
            BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
            String temp;
            int i=0;
            while(true) {
                temp = br.readLine();
                if(temp.contains("<a target=\"_blank\"")){
                    break;

                }
            }

//            System.out.println(temp);
            con.disconnect();
            br.close();
            return temp;
    }

}