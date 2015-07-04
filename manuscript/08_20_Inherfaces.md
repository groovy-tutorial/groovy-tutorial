# Interfaces

	interface SocialNetwork {
	    def friend(Member friend)
	
	    def unFriend(Member enemy)
	}
	
	class Member implements SocialNetwork {
	    String name
	    def friends = [] as Set
	
	    @Override
	    def friend(Member friend) {
	        friends << friend
	
	    }
	
	    @Override
	    def unFriend(Member enemy) {
	        friends -= enemy
	    }
	}
	
	def jim = new Member(name: 'Jim')
	def gina = new Member(name: 'Gina')
	def andrew = new Member(name: 'Andrew')
	
	print 'Jim makes some friends: '
	jim.friend(gina)
	jim.friend(andrew)
	jim.friends.each{print "$it.name "}
	
	println '\nJim makes an enemy'
	jim.unFriend(andrew)
	
	print 'Jim now has these friends: '
	jim.friends.each{print "$it.name "}