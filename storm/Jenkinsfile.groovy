node{
    stage("update Jenkins"){
        properties([parameters([string(defaultValue: '34.255.1.240', description: 'Please provide IP', name: 'ENVIR', trim: true)])])
        sh "echo Parameter added"
    }
    stage ("Install Git"){
        sh "ssh ec2-user@${ENVIR} sudo yum install git python-pip -y"
    }
    stage("Pull Repo"){
        sh "ssh ec2-user@${ENVIR}  git clone https://github.com/leventelibal/stormpath-flask-sample.git 2> /dev/null"
    }
    stage("Install Requirments"){
        sh "echo Hello"
    }
    stage("Pip Install"){
        sh "ssh ec2-user@${ENVIR} sudo pip install -r /home/ec2-user/stormpath-flask-sample/requirements.txt"
    }
    stage ("Run App"){
        sh "ssh ec2-user@${ENVIR} python  /home/ec2-user/stormpath-flask-sample/bootstrap.py"
    }
}