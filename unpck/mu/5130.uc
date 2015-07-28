class 5130 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect33
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.el_flame_strike_ta'
		bOnMultiTarget=True
	End Object
	Desc="플레임스트라이크타겟" //Flame Strike Target
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect33',SpecificStage=0)
}