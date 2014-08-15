#require 'soap/rpc/driver'  
#require 'soap/wsdlDriver'  
require 'tk'  
  
class SOAPGuiClient  
  def connect  
    @buttonconnect.configure('text' => 'Reset')  
    @buttonconnect.command { reset }  
  
    begin  

    rescue Exception => e  
      s = "Exception occured: " + e  
    ensure  
      @label.configure('text' => s)  
    end  
  end #connect  
  
  def reset  
    @label.configure('text' => "")  
    @buttonconnect.configure('text' => 'Connect')  
    @buttonconnect.command { connect }  
  end # reset  
  
#---  
  def initialize  
    root = TkRoot.new do  
      title 'SOAP Client'  
      # the min size of window  
      minsize(535, 100)  
    end  
#---  
    @label = TkLabel.new(root) do  
      pack  
    end  
#---  
    @buttonconnect = TkButton.new(root)  
    @buttonconnect.configure('text' => 'Connect')  
    @buttonconnect.command { connect }  
    @buttonconnect.pack('side'=>'bottom')  
#---  
    Tk.mainloop  
  end #initialize  
end # class  
  
SOAPGuiClient.new  
#---  