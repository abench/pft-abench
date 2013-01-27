Run("c:\tools\AddressBook.exe")
WinWaitActive("AddressBook Portable","",5000)
ControlClick("","","TRbButton4")
WinWaitActive("Add Contact","",5000)

;ControlClick("","","TDBEdit12")
;Send("hello")
ControlSend("","","TDBEdit12","hello");
Sleep(20000)