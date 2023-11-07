import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class Debugger {
    PrintStream out = System.out;
    InputStream in = System.in;
    PrintStream err = System.err;

    FileOutputStream stdoutWriter;
    FileOutputStream stderrWriter;
    FileOutputStream stdinWriter;


    PrintStream debugOut = new PrintStream(new OutputStream() {
        @Override
        public void write(int b) {
            try {
                stdoutWriter.write(b);
            } catch (IOException e) {}
            out.write(b);
        }
    });

    InputStream debugIn = new InputStream() {
        @Override
        public int read() {
            int val = -1;
            try {
                val = in.read();
            } catch (IOException e) {
                val = -1;
            }
            try {
                stdinWriter.write(val);
            } catch (IOException e) {}
            return val;
        }
    };

    PrintStream debugErr = new PrintStream(new OutputStream() {
        @Override
        public void write(int b) {
            try {
                stderrWriter.write(b);
            } catch (IOException e) {}
            err.write(b);
        }
    });

    public Debugger() {
        try {
            stdoutWriter = new FileOutputStream("stdout.txt");
            stderrWriter = new FileOutputStream("stderr.txt");
            stdinWriter = new FileOutputStream("stdin.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void hijack() {
        System.setOut(debugOut);
        System.setIn(debugIn);
        System.setErr(debugErr);
    }

    public void release() {
        System.setOut(out);
        System.setIn(in);
        System.setErr(err);
    }
}