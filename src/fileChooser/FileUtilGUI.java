package fileChooser;

import java.io.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Methods for operating files for fileChooser
 *
 * @author tadaki
 */
public class FileUtilGUI {

    /**
     * Prevent creating instances
     */
    private FileUtilGUI() {
    }

    /**
     * Open file and return content of file as string
     *
     * @param file specify file
     * @return content of file
     */
    static public String openFile(File file) {
        if (!file.canRead()) {//Conform the file readable
            showError("Can not read " + file.getName());
            return null;
        }
        //Start reading file
        BufferedReader in;
        try {
            in = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file)));//Open reader
        } catch (IOException ex) {//Failed to open reader
            showError(ex.getMessage());
            return null;
        }
        try {
            //Reading from the reader
            String str = readFromReader(in);
            in.close();
            return str;
        } catch (IOException ex) {//Failed to read from the reader
            showError(ex.getMessage());
            return null;
        }
    }

    /**
     * Read contents from Reader and return as String
     *
     * @param in BufferedReader
     * @return contents as a String
     * @throws IOException
     */
    static public String readFromReader(BufferedReader in) throws IOException {
        //Get the new line code independent of OS
        String nl = System.getProperty("line.separator");
        
        StringBuilder buf = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {//read one line
            buf.append(line);
            buf.append(nl);//new line
        }
        return buf.toString();
    }

    /**
     * Save text to file
     *
     * @param file specify file
     * @param text text for saving
     */
    static public void saveFile(File file, String text) {
        if (!checkWritable(file)) {//Confirm the file writable
            //If not writable, checkWritable() returns exception
            return;
        }
        try {
            //Start writing
            BufferedWriter out;
            try {
                out = new BufferedWriter(
                        new OutputStreamWriter(new FileOutputStream(file)));
            } catch (FileNotFoundException ex) {
                showError(ex.getMessage());
                return;
            }
            out.write(text);
            out.close();
        } catch (IOException ex) {
            showError(ex.getMessage());
        }
    }

    /**
     * Confirm the file writable
     *
     * @param file
     * @return
     */
    static public boolean checkWritable(File file) {
        boolean isWritable = true;
        if (file.isFile()) {//Confirm the file existing
            if (!file.canWrite()) {//Overwritable?
                showError("Can not write to " + file.getName());
                return false;
            } else {
                if (!checkOverwrite(file.getName())) {
                    return false;
                }
            }
        } else {//New file
            try {
                if (!file.createNewFile()) {//Create new file
                    showError("Can not create " + file.getName());
                    return false;
                }
            } catch (IOException ex) {
                showError(ex.getMessage());
                return false;
            }
        }
        return isWritable;
    }

    /**
     * Show dialog for confirming overwrite
     *
     * @param filename　File for saving
     * @return
     */
    static public boolean checkOverwrite(String filename) {
        boolean b = true;
        String message = filename + " exists. Do you overwrite?";
        int answer = JOptionPane.showConfirmDialog(
                new JFrame(), message, "Confirm overwrite",
                JOptionPane.OK_CANCEL_OPTION);
        if (answer != JOptionPane.OK_OPTION) {
            b = false;
        }
        return b;
    }

    /**
     * Show error dialog
     *
     * @param message error message
     */
    static public void showError(String message) {
        JOptionPane.showMessageDialog(
                new JFrame(), message, "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Show message dialog
     *
     * @param message
     */
    static public void showMessage(String message) {
        JOptionPane.showMessageDialog(
                new JFrame(), message, "Message",
                JOptionPane.INFORMATION_MESSAGE);
    }

}
