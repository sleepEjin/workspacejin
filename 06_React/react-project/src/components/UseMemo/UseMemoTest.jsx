import React from 'react'

const UseMemoTest = () => {
  return (
    <div>
        <h2>useMemo 최적화 테스트</h2>

        <div>
            <button>+</button>
            <button>-</button>
            <br />
            <input
                type='text'
                placeholder='글자를 입력하세요'
                value={text}
                onChange={onChangeText} />
        </div>
    </div>
  )
}

export default UseMemoTest