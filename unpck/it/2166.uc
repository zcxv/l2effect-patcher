class 2166 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect1
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.mo_war_cry_ta'
	End Object
	Desc="투지 게이지 물약" //Might Potion gauge
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect1',SpecificStage=0)
}