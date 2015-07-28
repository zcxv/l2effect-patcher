class 4641_b extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect10
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		EffectClass=Class'LineageEffect.mp_super_strike_b_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect11
		AttachOn=AM_Location
		EffectClass=Class'LineageEffect.mp_super_strike_a_co'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect12
		AttachOn=AM_Location
		EffectClass=Class'LineageEffect.mp_super_strike_a_cs'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect13
		offset=(X=-1.000000,Y=0.000000,Z=0.000000)
		EffectClass=Class'LineageEffect.mp_super_strike_b_ta'
	End Object
	Desc="몬스터 페이탈스트라이크B" //Monster B peyital strike
	CastingActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect10',SpecificStage=0)
	CastingActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect11',SpecificStage=0)
	CastingActions(2)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect12',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect13',SpecificStage=0)
}