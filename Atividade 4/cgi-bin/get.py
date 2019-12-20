#!/usr/bin/env python
import cgi, os

print("Content-type: text/html")
print()
print("<html><head><title>CGI - GET</title></head><body>")

for name, value in os.environ.items():
    print(name)
    print("= ")
    print(value)
    print("<br>")
    print("<br>")
print("</body></html>")
