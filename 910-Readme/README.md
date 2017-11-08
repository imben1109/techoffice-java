# Bat 

## Delete log files 
```
for /f %x in ('dir /b /s *.log*') do (git rm %x)
```


# Powershell
```
Get-ChildItem -dir | select {"* [" + $_.name + "](" + $_.name + "/)"}
```