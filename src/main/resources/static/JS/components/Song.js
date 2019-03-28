import Comments from './Comments'

export default function Song(song) {

    return `
        <h3 class="song__songTitle">${song.songTitle}</h3>
        <p class="song__duration">${song.duration}</p>
        <p class="song__link">${song.link}</p>
 
        <ul class="comments">
            <li class="comment">${Comments(song.comments)}</li>
        </ul>

        <section class="add__comment">
            <input type="text" class="add__commentContent" placeholder="Comment here">
            <button class="add__comment__button" id="${song.id}">Add Comment</button>
        </section>
            `
}