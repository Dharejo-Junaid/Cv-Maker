import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.IOException;

public class CvMaker {

    JFrame frame=new JFrame("Cv Maker");

    // Personal info;
    JTextField infoTextField[]=new JTextField[8];
    JRadioButton gender[]=new JRadioButton[2];
    ButtonGroup g=new ButtonGroup();

    // Qualifications;
    JTextField qualificationTextField[]=new JTextField[3];
    JComboBox<String>[] gradeComboBox=new JComboBox[3];
    JComboBox<String>[] yearComboBox=new JComboBox[3];

    // Work Experience;
    JTextField experienceTextField[]=new JTextField[3];

    // Skills;
    JTextField skillsTextField[]=new JTextField[3];

    // image label to show image;
    JLabel imageLabel=new JLabel();

    // file chooser of for image;
    JFileChooser choose=new JFileChooser();
    String path="";

    Font font=new Font("Consolas", Font.PLAIN, 17);
    Border border= BorderFactory.createLoweredBevelBorder();

    CvMaker() throws Exception {

        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        ImageIcon frameLogo=new ImageIcon(getClass().getResource("Logo1.png"));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1350,700);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setIconImage(frameLogo.getImage());

        // ------ titles of portions --------;
        JLabel top=new JLabel("CV Maker");
        top.setBounds(0,0, 1370,60);
        top.setFont(new Font("Verdana",Font.BOLD,50));
        top.setHorizontalAlignment(JLabel.CENTER);
        frame.add(top);


        // ____________________ Personal info _______________;
        JLabel infoTitle=new JLabel("Personal Information");
        infoTitle.setBounds(50,100,300,30);
        infoTitle.setFont(new Font("Consolas", Font.BOLD, 24));
        frame.add(infoTitle);

        JLabel infoLabel[] =new JLabel[9];
        String[] infoLabelText={"Name", "Father's Name", "Surname", "Date of Birth",
                "CNIC", "Email", "Address", "Contact #", "Gender"};
        for(int i=0;i<9;i++) {
            infoLabel[i] = new JLabel(infoLabelText[i]);
            infoLabel[i].setBounds(50, 100+ 50 * (i + 1), 120, 30);
            infoLabel[i].setFont(font);
            frame.add(infoLabel[i]);
        }

        for(int i=0;i<8;i++){
            infoTextField[i]=new JTextField();
            infoTextField[i].setBounds(170,100+50*(i+1),200,30);
            infoTextField[i].setFont(font);
            infoTextField[i].setBorder((border));
            frame.add(infoTextField[i]);
        }

        // setting gender info;
        for(int i=0;i<2;i++) {
            gender[i]=new JRadioButton((i%2==0)? "Male" : "Female");
            gender[i].setFont(font);
            gender[i].setFocusable(false);
            g.add(gender[i]);
            frame.add(gender[i]);
        }

        gender[1].setBounds(275,550,100,30);
        gender[0].setBounds(175,550,100,30);
        // _________________ End _______________;


        // ________________________ Qualifications ________________________;
        JLabel qualificationTitle=new JLabel("Qualifications");
        qualificationTitle.setBounds(425,100,300,30);
        qualificationTitle.setFont(new Font("Consolas", Font.BOLD, 24));
        frame.add(qualificationTitle);

        for(int i=0;i<3;i++){
            qualificationTextField[i]=new JTextField();
            qualificationTextField[i].setBounds(425,100+50*(i+1),250,30);
            qualificationTextField[i].setFont(font);
            qualificationTextField[i].setBorder(border);
            frame.add(qualificationTextField[i]);
        }

        String grades[]={"A+","A","B+","B","C+","C","F", " - "};
        for(int i=0;i<3;i++) {
            gradeComboBox[i]=new JComboBox(grades);
            gradeComboBox[i].setToolTipText("Grade");
            gradeComboBox[i].setBounds(710,100+50*(i+1),100,30);
            frame.add(gradeComboBox[i]);
        }

        String yearsArray[]=new String[26];
        for(int i=0; i<yearsArray.length; i++) {
            yearsArray[i]="" + (2022-i);
        }
        yearsArray[25] = "Curently Studing";

        for(int i=0;i<3;i++) {
            yearComboBox[i]=new JComboBox(yearsArray);
            yearComboBox[i].setToolTipText("Passing year");
            yearComboBox[i].setBounds(825,100+50*(i+1),100,30);
            frame.add(yearComboBox[i]);
        }
        // ________________________ /Qualifications ________________________;



        // ------------------- Work Experience ----------------------;
        JLabel experienceTitle=new JLabel("Work Experience");
        experienceTitle.setBounds(425,350,300,30);
        experienceTitle.setFont(new Font("Consolas", Font.BOLD, 24));
        frame.add(experienceTitle);

        JLabel experienceLabel[]=new JLabel[3];
        String[] experienceLabelText={"Company Name", "Duration", "Designation"};
        for(int i=0;i<3;i++){
            experienceLabel[i]=new JLabel(experienceLabelText[i]);
            experienceLabel[i].setBounds(425,350+50*(i+1),200,30);
            experienceLabel[i].setFont(font);
            frame.add(experienceLabel[i]);
        }

        for(int i=0;i<3;i++){
            experienceTextField[i]=new JTextField();
            experienceTextField[i].setBounds(570,350+50*(i+1),200,30);
            experienceTextField[i].setBorder(border);
            experienceTextField[i].setFont(font);
            frame.add(experienceTextField[i]);
        }
        // ------------------- /Work Experience ----------------------;


        // ------------------ Skills ---------------------;
        JLabel skillTitle=new JLabel("Skills");
        skillTitle.setBounds(850,350,300,30);
        skillTitle.setFont(new Font("Consolas", Font.BOLD, 24));
        frame.add(skillTitle);


        for(int i=0;i<3;i++){
            skillsTextField[i]=new JTextField();
            skillsTextField[i].setBounds(850,350+50*(i+1),200,30);
            skillsTextField[i].setFont(font);
            skillsTextField[i].setBorder(border);
            frame.add(skillsTextField[i]);
        }
        // ------------------- /Skills -----------------------;


        // ----------------- Image setUp ------------------;
        imageLabel.setBounds(1080,120,200,200);
        imageLabel.setBorder(border);
        imageLabel.setOpaque(true);
        frame.add(imageLabel);

        JButton imageButton=new JButton("Insert Image");
        imageButton.setBounds(1105,330, 150,30);
        imageButton.setFont(font);

        choose.setFileFilter(new FileNameExtensionFilter
                (null, "jpg", "png", "jpeg"));
        imageButton.addActionListener(e -> {
            choose.showOpenDialog(frame);
            path=choose.getSelectedFile().getPath();
            ImageIcon img=new ImageIcon(new ImageIcon(path).getImage()
                    .getScaledInstance(200, 200, Image.SCALE_DEFAULT));
            imageLabel.setIcon(img);
        });
        frame.add(imageButton);
        // ----------------- /Image setUp ------------------;


        // ------------- Generate Cv and Clear Buttons ----------;
        JButton generateCv=new JButton("Generate CV");
        generateCv.setBounds(1105, 520, 150, 30);
        generateCv.setFont(font);
        generateCv.addActionListener(e -> {

            boolean flag=true;

            for(int i=0; i<8; i++) {
                if(infoTextField[i].getText().equals("")) {
                    flag=false;
                    break;
                }
            }

            for(int i=0; i<3; i++) {
                if (qualificationTextField[i].getText().equals("")) {
                    flag = false;
                    break;
                }

                if (skillsTextField[i].getText().equals("")) {
                    flag = false;
                    break;
                }

                if (experienceTextField[i].getText().equals("")) {
                    flag = false;
                    break;
                }
            }

            if(!gender[0].isSelected() && !gender[1].isSelected())
                flag=false;

            if(imageLabel.getIcon()==null)
                flag=false;


            if(!flag) {
                JOptionPane.showMessageDialog(frame, "Please, Fill complete information");
            }

            else {
                try {
                    generateCv();
                    JOptionPane.showMessageDialog(frame, "Cv has been successfully generated");
                }
                catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        frame.add(generateCv);

        JButton clear=new JButton("Clear");
        clear.setBounds(1105, 560, 150, 30);
        clear.setFont(font);
        clear.addActionListener(e -> {
            for(int i=0; i<8; i++){
                infoTextField[i].setText("");
            }

            for(int i=0; i<3; i++) {
                qualificationTextField[i].setText("");
                skillsTextField[i].setText("");
                experienceTextField[i].setText("");
            }

            imageLabel.setIcon(null);
        });
        frame.add(clear);
        // ----------------- /Generate Cv and Clear Buttons ------------------;

        JLabel bottomLabel=new JLabel();
        bottomLabel.setBounds(0, 660, 1370, 50);
        bottomLabel.setText("Fill your information here and press \"Generate CV\" to get PDF of the CV");
        bottomLabel.setHorizontalAlignment(JLabel.CENTER);
        bottomLabel.setBorder(border);
        bottomLabel.setFont(new Font("Consolas", Font.ITALIC, 20));
        frame.add(bottomLabel);

        frame.setVisible(true);
    }

    public void generateCv() throws IOException {

        PdfFont alkalami = PdfFontFactory.createFont("src/main/java/Alkalami-Regular.ttf", true);
        PdfFont timesRoman = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);

        PdfWriter writer=new PdfWriter(System.getProperty("user.home")+ "\\Desktop\\" + infoTextField[0].getText() + " - cv.pdf");
        PdfDocument doc=new PdfDocument(writer);
        doc.addNewPage();
        doc.setDefaultPageSize(PageSize.A4);
        Document document = new Document(doc);

        // top Texts and components;
        Paragraph topParagraph=new Paragraph();

        Text cv=new Text("CURRICULUM VITAE\n").setFont(alkalami).setFontSize(16).setItalic().setUnderline();
        document.add(new Paragraph().add(cv).setTextAlignment(TextAlignment.CENTER));

        Text name=new Text(infoTextField[0].getText() + "\n").setFont(timesRoman).setFontSize(35)
                .setItalic().setWordSpacing(0.1f);
        topParagraph.add(name);

        Text contactHeading=new Text("Contact Information\n").setFont(timesRoman).setUnderline().setFontSize(16);
        topParagraph.add(contactHeading);

        Text contactInfo=new Text("Phone: " + infoTextField[7].getText() + "\n"
                + "Email: " + infoTextField[5].getText() + "\n"
                + "Address: " + infoTextField[6].getText() + "\n\n"
        ).setFont(timesRoman).setFontSize(14);
        topParagraph.add(contactInfo);
        document.add(topParagraph);


        // ------------------------- Image -------------------------;

        ImageData imgData= ImageDataFactory.create(path);
        com.itextpdf.layout.element.Image img=new com.itextpdf.layout.element.Image(imgData);
        img.setWidth(100);
        img.setHeight(120);
        img.setFixedPosition(420, 620);
        document.add(img);


        // -------------------- Objective ----------------------
        float[] objectiveHeadingTableArr ={550f};
        Table objectiveheading=new Table(objectiveHeadingTableArr);
        objectiveheading.addCell(new Cell().add("Objective").setFont(timesRoman).setFontSize(14)
                .setTextAlignment(TextAlignment.CENTER).setBackgroundColor(com.itextpdf.kernel.color.Color.ORANGE));
        document.add(objectiveheading);

        Paragraph objectiveParagraph=new Paragraph();
        Text objectiveText=new Text("Seeking a challenging position in a reputed organization" +
                " where I can learn new skills, expand my knowledge and leverage my learnings.\n\n")
                .setFont(timesRoman).setFontSize(14);
        objectiveParagraph.add(objectiveText);
        document.add(objectiveParagraph);
        // -------------------- /Objective ----------------------

        // ------------------Personal Info -----------------------
        Table personalInfoHeading=new Table(new float[]{550f});
        personalInfoHeading.addCell(new Cell().add("Personal Information").setFont(timesRoman).setFontSize(14)
                .setTextAlignment(TextAlignment.CENTER).setBackgroundColor(com.itextpdf.kernel.color.Color.ORANGE));
        document.add(personalInfoHeading);

        Table personalInfoContent=new Table(new float[]{275f, 275});
        personalInfoContent.setFont(timesRoman).setFontSize(14);

        personalInfoContent.addCell(new Cell().add(new com.itextpdf.layout.element.List().add("Father's Name").setListSymbol("  ")));
        personalInfoContent.addCell(new Cell().add(new com.itextpdf.layout.element.List().add(infoTextField[1].getText()).setListSymbol("  ")));

        personalInfoContent.addCell(new Cell().add(new com.itextpdf.layout.element.List().add("Surname").setListSymbol("  ")));
        personalInfoContent.addCell(new Cell().add(new com.itextpdf.layout.element.List().add(infoTextField[2].getText()).setListSymbol("  ")));

        personalInfoContent.addCell(new Cell().add(new com.itextpdf.layout.element.List().add("Gender").setListSymbol("  ")));
        personalInfoContent.addCell(new Cell().add(new com.itextpdf.layout.element.List().add(gender[0].isSelected()? "Male" : "Female").setListSymbol("  ")));

        personalInfoContent.addCell(new Cell().add(new com.itextpdf.layout.element.List().add("Date of Birth").setListSymbol("  ")));
        personalInfoContent.addCell(new Cell().add(new com.itextpdf.layout.element.List().add(infoTextField[3].getText()).setListSymbol("  ")));

        personalInfoContent.addCell(new Cell().add(new com.itextpdf.layout.element.List().add("CNIC").setListSymbol("  ")));
        personalInfoContent.addCell(new Cell().add(new com.itextpdf.layout.element.List().add(infoTextField[4].getText()).setListSymbol("  ")));
        document.add(personalInfoContent);

        document.add(new Paragraph().add("\n"));

        // --------------------- Qualifications --------------------------
        Table qualificationHeading=new Table(new float[]{550f});
        qualificationHeading.addCell(new Cell().add("Qualifications").setFont(timesRoman).setFontSize(14)
                .setTextAlignment(TextAlignment.CENTER).setBackgroundColor(com.itextpdf.kernel.color.Color.ORANGE));
        document.add(qualificationHeading);

        Table qualificationContent=new Table(new float[]{183.33f, 183.33f, 183.33f});
        qualificationContent.setFont(timesRoman).setFontSize(15);

        qualificationContent.addCell(new Cell().add("Education"));
        qualificationContent.addCell(new Cell().add("Grade"));
        qualificationContent.addCell(new Cell().add("Passing Year"));

        qualificationContent.addCell(new Cell().add("  " + qualificationTextField[0].getText()));
        qualificationContent.addCell(new Cell().add("  " + gradeComboBox[0].getSelectedItem()));
        qualificationContent.addCell(new Cell().add("  " +  yearComboBox[0].getSelectedItem()));


        qualificationContent.addCell(new Cell().add("  " + qualificationTextField[1].getText()));
        qualificationContent.addCell(new Cell().add("  " +  gradeComboBox[1].getSelectedItem()));
        qualificationContent.addCell(new Cell().add("  " +  yearComboBox[1].getSelectedItem()));

        qualificationContent.addCell(new Cell().add("  " + qualificationTextField[2].getText()));
        qualificationContent.addCell(new Cell().add("  " +  gradeComboBox[2].getSelectedItem()));
        qualificationContent.addCell(new Cell().add("  " +  yearComboBox[2].getSelectedItem()));

        document.add(qualificationContent);

        document.add(new Paragraph().add("\n"));


        // ----------------------- Skills ----------------------------
        Table skillsHeading=new Table(new float[]{550f});
        skillsHeading.addCell(new Cell().add("Skills").setFont(timesRoman).setFontSize(14)
                .setTextAlignment(TextAlignment.CENTER).setBackgroundColor(com.itextpdf.kernel.color.Color.ORANGE));
        document.add(skillsHeading);

        document.add(new Paragraph().add("\n").setFontSize(5));

        com.itextpdf.layout.element.List skillList=new com.itextpdf.layout.element.List();
        skillList.setFont(timesRoman).setFontSize(14);
        skillList.add(skillsTextField[0].getText())
                .add(skillsTextField[1].getText()).add(skillsTextField[2].getText());
        document.add(skillList);

        document.add(new Paragraph().add("\n"));

        // -------------------- Experience --------------------;
        Table experienceHeading=new Table(new float[]{550f});
        experienceHeading.addCell(new Cell().add("Experience").setFont(timesRoman).setFontSize(14)
                .setTextAlignment(TextAlignment.CENTER).setBackgroundColor(com.itextpdf.kernel.color.Color.ORANGE));
        document.add(experienceHeading);

        document.add(new Paragraph().add("\n").setFontSize(5));

        com.itextpdf.layout.element.List experienceList=new com.itextpdf.layout.element.List();
        experienceList.setFont(timesRoman).setFontSize(14);
        experienceList.add("Company name: " + experienceTextField[0].getText())
                .add("Duration: " + experienceTextField[1].getText()).add("Designation: " + experienceTextField[2].getText());
        document.add(experienceList);

        document.close();
    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        new CvMaker();
    }
}
