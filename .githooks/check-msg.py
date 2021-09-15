#!/usr/bin/env python

import sys, os, re
from subprocess import check_output

branch = check_output(['git', 'symbolic-ref', '--short', 'HEAD']).strip()
print(branch)

url = "https://api.github.com/repos/franklinmatheus/training/issues"

print("OK")

