interface SocialNetwork {
    Member friend(Member friend)
    Member unFriend(Member enemy)
}

interface Posts {
    Map getPosts()
    void addPost(String title, String body)
}

class Member implements SocialNetwork, Posts {
    String name
    def friends = [] as Set
    Map posts = [:]

    @Override
    Member friend(Member friend) {
        friends << friend
        friend
    }

    @Override
    Member unFriend(Member enemy) {
        friends -= enemy
        enemy
    }

    @Override
    void addPost(String title, String body) {
        posts << [title: body]
    }
}

def jim = new Member(name: 'Jim')
def gina = new Member(name: 'Gina')
def andrew = new Member(name: 'Andrew')

jim.with {
    println 'Jim makes some friends: '
    friend(gina)
    friend(andrew)
    friends.each { println " - $it.name" }

    println '\nJim makes an enemy of Andrew'
    unFriend(andrew)

    println '\nJim now has these friends: '
    friends.each { println " - $it.name " }

    println '\nAdding a post'
    addPost('My weekend', 'Just hung out and stuff')
    println getPosts()
}
