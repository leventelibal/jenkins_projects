node{
    stage("update Jenkins"){
        properties([parameters([string(defaultValue: '34.255.1.240', description: 'Please provide IP', name: 'Environment ', trim: true)])])
        sh "Echo Parameter added"
    }
    stage ("Install Git"){
        sh "ssh ec2-user@${Environment} sudo yum install git -y"
    }
    stage("Pull Repo"){
        sh "ssh ec2-user@${Environment} git clone https://github.com/miguelgrinberg/flask-examples.git"
    }
    stage("Install Requirments"){
        //sh "virtualenv /tmp/venv"
        //sh ". venv/bin/activate"
        sh "echo Hello"
    }
    stage("Pip Install"){
        sh "ssh ec2-user@${Environment} pip install -r ~/flask-examples/requirements.txt"
    }
    stage ("Run App"){
        sh "ssh ec2-user@${Environment} python  ~/flask-examples//01-hello-world/hello.py"
    }
}