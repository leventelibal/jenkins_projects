node{
    stage("update Jenkins"){
        properties([parameters([string(defaultValue: '34.255.1.240', description: 'Please provide IP', name: 'ENVIR', trim: true)])])
        sh "Echo Parameter added"
    }
    stage ("Install Git"){
        sh "ssh ec2-user@${ENVIR} sudo yum install git python-pip -y"
    }
    stage("Pull Repo"){
        sh "ssh ec2-user@${ENVIR} git clone https://github.com/miguelgrinberg/flask-examples.git"
    }
    stage("Install Requirments"){
        //sh "virtualenv /tmp/venv"
        //sh ". venv/bin/activate"
        sh "echo Hello"
    }
    stage("Pip Install"){
        sh "ssh ec2-user@${ENVIR} pip install -r ~/flask-examples/requirements.txt"
    }
    stage ("Run App"){
        sh "ssh ec2-user@${ENVIR} python  ~/flask-examples//01-hello-world/hello.py"
    }
}