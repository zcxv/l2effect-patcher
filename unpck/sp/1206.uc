class 1206 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect6
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSizeScale=True
		EffectClass=Class'LineageEffect.m_u009_a'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect7
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.m_u009_c'
		bOnMultiTarget=True
	End Object
	Desc="윈드 셰클" //Wind Shackle
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect6',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect7',SpecificStage=0)
}