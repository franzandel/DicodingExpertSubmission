#
#           Circle CI & gradle.properties live in harmony
#
# Android convention is to store your API keys in a local, non-versioned
# gradle.properties file. Circle CI doesn't allow users to upload pre-populated
# gradle.properties files to store this secret information, but instaed allows
# users to store such information as environment variables.
#
# This script creates a local gradle.properties file on current the Circle CI
# instance. It then reads environment variable TEST_API_KEY_ENV_VAR which a user
# has defined in their Circle CI project settings environment variables, and
# writes this value to the Circle CI instance's gradle.properties file.
#
# You must execute this script via your circle.yml as a pre-process dependency,
# so your gradle build process has access to all variables.
#
#   dependencies:
#       pre:
#        - source environmentSetup.sh && copyEnvVarsToGradleProperties

#!/usr/bin/env bash

function copyEnvVarsToLocalProperties {
    FAKE_LOCAL_PROPERTIES=$HOME"/local.properties"
    export FAKE_LOCAL_PROPERTIES
    echo "Local Properties should exist at $FAKE_LOCAL_PROPERTIES"

    if [ ! -f "$FAKE_LOCAL_PROPERTIES" ]; then
        echo "Local Properties does not exist"

        echo "Creating Fake Local Properties file..."
        touch $FAKE_LOCAL_PROPERTIES

        echo "Writing API KEY to Fake local.properties..."
        echo "release_alias_keystore=$release_alias_keystore_env_var" >> $FAKE_LOCAL_PROPERTIES
        echo "release_pass_keystore=$release_pass_keystore_env_var" >> $FAKE_LOCAL_PROPERTIES
        echo "games_api_key=$games_api_key_env_var" >> $FAKE_LOCAL_PROPERTIES

        echo "Display Content Fake Local Properties"
        cat $FAKE_LOCAL_PROPERTIES

        ls -all $HOME/repo
    fi
}