import os
import shutil

os.mkdir("new_dir")
[open(f"new_dir/{ext}", "w").close() for ext in ["txt", "py", "sh", "java"]]

current_working_dir = os.getcwd()

for file in os.listdir(current_working_dir):
  file_stats = os.stat(file)
  file_permissions = oct(file_stats.st_mode & 0o777)
  print(f"{file}: {file_permissions}")

os.system("git init")
os.system("git add .")
os.system("git commit -m 'firt commit'")
os.system("git remote add origin <remote_repository_url>")
os.system("git push origin linux")