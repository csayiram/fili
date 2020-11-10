#!/bin/bash

#screwdriver/git_credentials.bash

#pick up the tags from the adjusted remote
git fetch --unshallow
git fetch --tags

echo $(git branch -v)

#get the last tag on this branch
LAST_TAG=$(git describe)
echo "INFO Last tag: $LAST_TAG"

#Build the new tag to push
NEW_TAG=$(LAST_TAG=${LAST_TAG} python screwdriver/upversion.py)
echo "INFO Creating tag: $NEW_TAG"
git tag $NEW_TAG -a -m "Autogenerated version bump tag"

#push the new tag
echo "INFO Pushing tag"
git push origin $NEW_TAG
