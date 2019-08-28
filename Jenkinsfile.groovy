node{
    stage("update Jenkins"){
        properties([parameters([string(defaultValue: '34.255.1.240', description: 'Please provide IP', name: 'Environment ', trim: true)])])
        sh "Echo Parameter added"
    }
    stage ("Install Git"){
        sh "sudo yum install git -y"
    }
    stage("Pull Repo"){
        git "https://github.com/miguelgrinberg/flask-examples.git"
    }
    stage("Install Requirments"){
        //sh "virtualenv /tmp/venv"
        //sh ". venv/bin/activate"
        sh "echo Hello"
    }
    stage("Pip Install"){
        sh "pip install -r requirements.txt"
    }
    stage ("Run App"){
        sh "python /tmp/venv/01-hello-world/hello.py"
    }
}