# Bat 

## Delete log files 
```
for /f %x in ('dir /b /s *.log*') do (git rm %x)
```