public class Transport implements Transportable {
 private String smtpHost;
 private String smtpResponse;
 private int smtpPort;

 public Transport() {}


 public void send(Message msg) throws
TransportException {

 PrintWriter out = null;
 BufferedReader in = null;

    try { Socket s = new Socket( this.smtpHost,
    this.smtpPort );
    out = new PrintWriter( s.getOutputStream(),
    true );
    in = new BufferedReader( new
    InputStreamReader( s.getInputStream() ) );
    if( smtpErrorExists( in,"220" ) ) {
        throw new TransportException( "Can't
        connect to: " + this.smtpHost + ". Port: " +
        this.smtpPort + "\t" + this.smtpResponse ); }
    }
    catch( IOException ioe ) {
    throw new TransportException( "Can't
    connect to: " + this.smtpHost + ". Port: " +
    this.smtpPort + "\t " );
    }
 sendMessage( msg, in, out );
 }


private void sendMessage(Message msg,
BufferedReader in, PrintWriter out) throws
TransportException {
    out.println( "HELLO " + this.smtpHost );
    if( smtpErrorExists( in,"250" ) ) {
         throw new TransportException( "SMTP error:
        HELO failed.\t" + smtpResponse );
 }
 Address[] from = msg.getFrom();
    if( from == null ) {
        throw new TransportException( "SMTP error:
        No FROM address specified, can't send email.\t " );
    }
    else {}
}
}

// Try to understand the characteristics of what a component and interface is i the context of Software Architecture and design. then try to identify these in this code.