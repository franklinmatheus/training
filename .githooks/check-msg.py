#!/usr/bin/env python

import sys, os, re
from subprocess import check_output

branch = check_output(['git', 'symbolic-ref', '--short', 'HEAD']).strip()
print(branch)

url = "https://api.github.com/repos/franklinmatheus/training/issues"
commit_msg_filepath = sys.argv[0]
print(sys.argv)

with open(commit_msg_filepath, 'r') as f:
    content = f.read()
    if not content.startswith():
        #print("commit-msg: ERROR! The commit message must start with")
        #sys.exit(1)
        print(content)

print("OK")

