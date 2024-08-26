function lockedProfile() {
    const allProfilesElements = document.querySelectorAll('.profile');

    allProfilesElements.forEach(profile => {
        const lockButton = profile.querySelector('input[type=radio][value=lock]');
        const showMoreButton = profile.querySelector('button');

        showMoreButton.addEventListener('click', (e) => {
            if (!lockButton.checked) {
                const hiddenFields = profile.querySelector('.profile div');

                if (showMoreButton.textContent === 'Show more') {
                    hiddenFields.style.display = 'block';
                    showMoreButton.textContent = 'Hide it';
                } else if (showMoreButton.textContent === 'Hide it') {
                    hiddenFields.style.display = 'none';
                    showMoreButton.textContent = 'Show more';
                }
            }
        });
    });
}