class FriendsContainer extends React.Component {
    constructor(props) {
      super(props)
  
      this.state = {
        name: 'Tyler McGinnis',
        friends: [
          'Jake Lingwall',
          'Sarah Drasner',
          'Merrick Christensen'
        ],
      }
  
      this.addFriend = this.addFriend.bind(this)
    }
    addFriend(friend) {
      this.setState((state) => ({
        friends: state.friends.concat([friend])
      }))
    }
    render() {
      return (
        <div>
          <h3> Name: {this.state.name} </h3>
          <AddFriend addNew={this.addFriend} />
          <ShowList names={this.state.friends} />
        </div>
      )
    }
  }