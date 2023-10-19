import os

filenames = ["README.md", "LICENSE", ".gitignore"]
for filename in filenames:
    if os.path.exists(filename):
        print(f"{filename}")
    else:
        print(f"{filename} doesn't exist")
