#!/usr/bin/env python
import glob
import os
directory='.'
os.chdir(directory)
files=glob.glob('*.sh')
for filename in files:
    os.unlink(filename)