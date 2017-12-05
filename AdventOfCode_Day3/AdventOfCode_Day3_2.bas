Attribute VB_Name = "Module1"
Sub AdventOfCode_Day3_2()
Dim grid(600, 600)

For ql = 1 To 600
  For ql2 = 1 To 600
    grid(ql, ql2) = 0
  Next
Next

StartX = 300: StartY = 300: CurrX = 300: CurrY = 300
TargetVal = 312051
sqsize = 1: curval = 1

grid(StartX, StartY) = 1
While curval < TargetVal
    For Sides = 1 To 2
     For walk = 1 To sqsize
       curval = 0
       If sqsize Mod 2 = 0 Then
         If Sides = 1 Then
           CurrX = CurrX - 1
         Else
           CurrY = CurrY - 1
         End If
       Else
         If Sides = 1 Then
           CurrX = CurrX + 1
         Else
           CurrY = CurrY + 1
         End If
       End If
       For ql = -1 To 1
         For ql2 = -1 To 1
           curval = curval + grid(CurrX + ql, CurrY + ql2)
         Next
       Next
       grid(CurrX, CurrY) = curval
       If curval > TargetVal And Cells(1, 1) = "" Then
         outstring$ = Str$(CurrX) + " " + Str$(CurrY) + " " + Str$(sqsize) + " " + Str$(curval)
         Cells(1, 1) = outstring$
         
       End If
      Next
    Next
    sqsize = sqsize + 1
Wend

End Sub
